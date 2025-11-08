import { CardItem } from "../views/CardItem";
import { RedirectionButton } from "../views/RedirectionButton";
import { examples } from "./ProjectsRepo";

export const LittleProjects = () => {
    return <div className="homePostContainer">
            {examples.map(
                postData => <CardItem {...postData} >
                    <RedirectionButton route={postData.route} />
                </CardItem>
            )}
    </div>;
}