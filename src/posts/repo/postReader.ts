import { useState, useEffect } from "react";
import { postsMap } from "./postRepo";

export const PostReader = (id: string) => {
    const [markdownContent, setMarkdownContent] = useState('');
      useEffect(() => {
        const raw = postsMap[id || ""] || "";
        // Resolve to an absolute URL so browser won't prepend the current route (e.g. /post/)
        const resolvedUrl = raw ? new URL(raw, window.location.origin).href : raw;
        fetch(resolvedUrl)
          .then(response => response.text())
          .then(text => setMarkdownContent(text))
          .catch(err => console.error('Error fetching markdown:', err));
      }, [id]);
    return markdownContent;
}