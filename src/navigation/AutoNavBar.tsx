import { useEffect, useState } from "react";
import { Box, List, ListItem, Link, Typography } from "@mui/material";

// Import the new CSS file
import "./autoNavBar.css";

interface HeadingData {
  id: string;
  text: string | null;
  level: string;
}

interface AutoNavbarProps {
  markdown: string;
}

const AutoNavbar = ({ markdown }: AutoNavbarProps) => {
  const [headings, setHeadings] = useState<HeadingData[]>([]);

  // This effect logic is unchanged.
  useEffect(() => {
    const headingElements = Array.from(
      document.querySelectorAll(
        ".postPage h1, .postPage h2, .postPage h3, .postPage h4, .postPage h5, .postPage h6"
      )
    ) as HTMLElement[];

    const headingData: HeadingData[] = headingElements.map(
      (heading: HTMLElement) => {
        const generatedId = (heading.textContent || "")
          .replace(/\s+/g, "-")
          .toLowerCase();

        return {
          id: heading.id || generatedId,
          text: heading.textContent,
          level: heading.tagName,
        };
      }
    );

    headingElements.forEach((heading: HTMLElement, index) => {
      if (!heading.id) {
        heading.id = headingData[index].id;
      }
    });

    setHeadings(headingData);
  }, [markdown]);

  // Helper function for DYNAMIC indentation (must stay in component)
  const getIndentation = (level: string): number => {
    const levelNumber = parseInt(level.slice(1), 10);
    return (levelNumber - 1) * 10;
  };

  return (
    <Box
      component="nav"
      // Apply the main class from the CSS file
      className="auto-navbar"
    >
      <Typography
        variant="h6" // Keep variant for semantics
        component="h2"
        // Apply the title class
        className="auto-navbar-title"
      >
        On this page
      </Typography>

      <List
        // Apply the list class
        className="auto-navbar-list"
      >
        {headings.map((heading) => (
          <ListItem
            key={heading.id}
            disablePadding
            // Apply the item class
            className="auto-navbar-item"
            // DYNAMIC style: This cannot go in the CSS file
            style={{
              paddingLeft: `${getIndentation(heading.level)}px`,
            }}
          >
            <Link
              href={`#${heading.id}`}
              // Apply the base link class AND the dynamic level class
              className={`auto-navbar-link level-${heading.level}`}
            >
              {heading.text}
            </Link>
          </ListItem>
        ))}
      </List>
    </Box>
  );
};

export default AutoNavbar;