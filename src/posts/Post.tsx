import { useParams } from "react-router-dom";
import ReactMarkdown from "react-markdown";
import './postPage.css';
import { PostReader } from "./repo/postReader";
import AutoNavbar from "../navigation/AutoNavBar";

// Component to display the post detail based on the ID from the URL
export const PostDetail = () => {
  const { id } = useParams(); // Get the 'id' parameter from the URL
  return <PostContent id={id || ""} />
};

interface PostContentProps {
  id: string;
}

export const PostContent = ({ id }: PostContentProps) => {
  window.scrollTo(0, 0);
  const markdownContent = PostReader(id || ""); 
  return <div className="postDetailContainer">
    <div className="postPage">
      <div className="textContent">
        <ReactMarkdown children={markdownContent} />
      </div>
    </div>
    <div className="rightNavBar">
      <AutoNavbar markdown={markdownContent}/>
    </div>
  </div>
}