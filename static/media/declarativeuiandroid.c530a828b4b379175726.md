# Thoughts about declarative UI on Android and other opinions

***The experience from who learn XML views and later on knew of Declarative UI concepts***

Jetpack compose brings to Android Native Development a great concept as it is the Declarative UI, that until that moment was something that you would find only on the hybrid frameworks like React Native and Flutter. It was 2021 when this great tool was finally in beta and many of us jumped to test it and use it on some real products outside. 

In my special case, I started to use it really like 2 years ago, but I was familiar with all the concepts behind the Declarative UI thanks to work in some projects with React Native, Flutter and React with Capacitor. Also, I use that concept building a small blog that uses Kotlin React.

I like the concept behind the Declarative UI, and how you can create Stateless UI, that reduces the capacity of introducing bugs. I don’t want to sell you the idea that Jetpack compose is the best that happens to the Android world, actually I want to share with you some concerns that I have using this tool, and how I would like to be the direction of Android Native development, then, lets go.

## Screens, screens, screens

You can find a lot of Android Screen sizes on the market. There are many of them, and there are other kinds of devices that are capable of running Android. Actually today we can say that the screen sizes are almost the same, but we are still talking about a lot of screen sizes. In the past XML brought to us a simple solution: you can have a specific XML layout per density of screen. Then you could have a layout distribution for 480p or lower, one for 720p or lower and other for more that 1000p and the operative system will select which layout would be the fit for that specific screen. 

On compose you need logic inside of the composable functions, an approach that adds and in almost most of the cases, an unnecessary logic on XML. It is a small portion of logic, but at the end of the day logic, that means that you need to care about more variables, state, and conditions. Those validations increase the code's cognitive complexity, and everyone knows that less complexity is always the best.

## Custom Views vs Composable functions

Composable functions are simple, more simple than Custom Views, at least in practice, you need to take care about the lifecycle of the Custom View, which is more simple than the lifecycle of an Activity or Fragment, but it is a lifecycle after all. Composable functions are then a simplification of that, no “lifecycle”, and a lot of ways to solve problems using composition. As custom view requires layout inflation (one lovely old android concept), that makes them as the activities and fragments, something hard to work.

Then, Compose is the best right? And I would like to say, yes but. The reason behind this lies with the previous point, but something to me is what we lost in the process of migrating from views to composable functions, and it is more a developer problem than anything, that is the encapsulation. And yes, believe it or not, Custom View forces the encapsulation. The reason behind that was the complexity of the custom view itself, because they are too verbose, you need to spend a lot of lines to put a value in them, but once they were created, you won’t modify them a lot. They were on many occasions part of a common view library. Of course this is more a developer problem than anything, and you can achieve the same encapsulation with the composable functions, but as they are more simple to change, I am watching less and less pre-solve composable functions to use. Behind the complexity was a reason to reuse something already solved, and today I saw too many developers creating the same solution again and again because it is easy.

## Too many things to remember

Flutter on its paradigm has something I like a lot that are the stateless components. That concept of not having a state on the view, remains a lot the concept of pure functions that only receives params and processes them to generate a result, instead that our result in a stateless component is a view. I won’t explain here why not having state on functions is something good to have, but I want to mention that when I saw compose, the first thing I thought was: "finally we could produce a pure view function”.

Actually you can do it, because the android framework has all the tools to allow it, but then, you can see that the remembers exists, and someone else could use them. This to me is some kind of contradiction because we have already an android component with that purpose how it is the ViewModel, and the remembers allow almost the same objective to have an state, then, if you are not careful you will end taking care of 2 different states on the same UI, because you implement a solution that it was more simple with a remember that with a ViewModel. 

This in fact could be true, that a ViewModel sometimes is a big tool to solve simple problems, but not having the possibility to define something as stateless as flutter does, feels to me that a big missing piece on the compose framework.

## Final conclusions

I would like to say something else: I don’t have doubts that compose is a great tool on the android framework. What tricks to me is the feeling that somethings feel disconnected, for example how many time takes to dagger hilt to support KVM, how the same dagger hilt enforces the ViewModel use on Composable functions, but not how we can enforce the use of the same on those functions and can be easily create other states with the potential side effects that have more than one state can cause. How Koin is a better DI framework than dagger hilt, how we need to add more logic to the view because we need to support different screen sizes, adding more a more code to maintain, and how easily we can break our composable functions because we don’t have ways on the framework to ensure the architecture of an application. I know that all the points actually are the consequence of developer behaviours, and it is our responsibility to produce good code, but it would be nice to have as well the tools to produce it. 

*Created on 2025-09-05*   
*by Pedro Gomez*  
