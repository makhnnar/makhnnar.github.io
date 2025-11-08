import { posts } from "../posts/repo/postRepo";
import { CardItem } from "../views/CardItem";

import "./home.css";
import { NavigationButton } from "../views/NavigationButton";

export const Home = () => {
    return (
        <div className="homePostContainer">
            {posts.map(
                postData => <CardItem {...postData} >
                    <NavigationButton route={postData.route} />
                </CardItem>
            )}
        </div>
    );
}