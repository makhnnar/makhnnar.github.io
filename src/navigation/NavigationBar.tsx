import { useEffect, useState } from 'react';
import { AppBar, Toolbar, Typography, Button, Box } from '@mui/material';
import { Link } from "react-router-dom";

import "./navigationBar.css";

type SelectedButton = 'post' | 'myCV' | 'littleProjects';

const pathToSelected: { [key: string]: SelectedButton } = {
  '/myCV': 'myCV',
  '/littleProjects': 'littleProjects',
};

const getSelectedFromPath = (
  path:string,
  selected:string,
  setSelected: (value: SelectedButton) => void
) => {
  const checkedPath = pathToSelected[path] || 'post'
  if(checkedPath===selected) return;
  setSelected(checkedPath);
}

export const NavigationBar = () => {
  const [selected, setSelected] = useState<SelectedButton>('post');

  useEffect(() => {
    getSelectedFromPath(
      window.location.pathname,
      selected, 
      setSelected
    );
  }, [selected]);

  return (
    <AppBar position="static">
      <Toolbar>
        <Typography
          variant="h6"
          component="div"
          className="topBarTitle"
        >
          Pedro's Blog
        </Typography>
        <Box className="navButtonContainer">
          <Button
            color="inherit"
            variant={selected === 'post' ? 'outlined' : 'text'}
            component={Link}
            to="/"
            onClick={() => setSelected('post')}
          >
            Post
          </Button>

          <Button
            color="inherit"
            variant={selected === 'myCV' ? 'outlined' : 'text'}
            component={Link}
            to="/myCV"
            onClick={() => setSelected('myCV')}
          >
            My CV
          </Button>

          <Button
            color="inherit"
            variant={selected === 'littleProjects' ? 'outlined' : 'text'}
            component={Link}
            to="/littleProjects"
            onClick={() => setSelected('littleProjects')}
          >
            Little Projects
          </Button>
        </Box>
      </Toolbar>
    </AppBar>
  );
};