
import post1 from "./howibecame.md";
import profile from "./profile.md";
import post2 from "./gooddevpractices.md";
import post3 from "./declarativeuiandroid.md";
import post4 from "./hiringexperiences.md";

export const postsMap: Record<string, string> = {
    "how-i-became": post1,
    "profile": profile,
    "good-dev-practices": post2,
    "declarative-ui-android": post3,
    "hiring-experiences": post4,
};

const softEng = {
    title: "How I Became a Software Engineer",
    description: "A short story about my journey into software engineering, the challenges I faced, and all the people that helps to it.",
    imageUrl: "/softwareengineer.jpg",
    route: "/post/how-i-became"
};

const goodPracts = {
    title: "Good Development Practices",
    description: "Things that I've learned over the years that can help you become a better sofware engineer.",
    imageUrl: "/runners.jpg",
    route: "/post/good-dev-practices"
};

const declarativeUI = {
    title: "Declarative UI in Android",
    description: "An introduction to declarative UI in Android using Jetpack Compose.",
    imageUrl: "/declarativeui.png",
    route: "/post/declarative-ui-android"
};

const hiringExp = {
    title: "My Hiring Experiences",
    description: "Sharing my experiences during the hiring process, including interviews and assessments.",
    imageUrl: "/jobinterview.jpg",
    route: "/post/hiring-experiences"
};

export const posts = [softEng, goodPracts, declarativeUI, hiringExp];
