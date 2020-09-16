# ShareMyBrain

## Educational project from Wild Code School

### Introduction

#### Instructions

>**Mutual aid and knowledge sharing !**
>You have skills and wish to share it with the community: it's possible with ShareMyBrain!
>Give your skills and answer to the questions asked by the other users.


#### Work Context

ShareMyBrain is a four-week group project based on **SCRUM agile methodology**. 

Due to the lockdown, this project has been led in **full-remote**. 

#### User stories - features summary

- **Creation of a account**: a new user can create an account on the platform. 
- **Log-in**: a user who owns an account can connect to enter the website.
- **Log-out**: a logged user can log out from the website.
- **Password edition**: a user can change its password
- **Question asking**: a user can ask a public question about any skills from the database.
- **Question answering**: a user can post an answer for questions regarding its choosen skill. 
- **Profile display**: a user can access the questions and answers he wrote from his profile.
- **Question research by key word**: a user can search for question by taping specific key words in a search bar.
- **Questions sorting by date**: lists of questions/answers can be sorted by date.
- **Questions/answers pagination display**: if more than three questions/answers are returned, a pagination system is displayed.
- **Responsivity**: the website adapt the display for desktop and mobiles.
- **404 error**: if a 404 error occurs, the website returns a personalised page.


#### Authors

- [Aurélien Lonni](https://github.com/0reldev)
- [Élise Godard](https://github.com/elisego)
- [Mariana Roldan](https://github.com/mroldan747) 


### Features presentation

#### Home page

##### Desktop version
![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-desktop-1.png?raw=true)

##### Mobile version
![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-mobile-1.png?raw=true)
![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-mobile-2.png?raw=true)

##### Burger menu in mobile version
![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-mobile-4.png?raw=true)


#### Account creation

##### Desktop version
![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-desktop-2.png?raw=true)

##### Mobile version
![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-mobile-13.png?raw=true)
![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-mobile-14.png?raw=true)


#### Log-in

##### Desktop version
![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-desktop-3.png?raw=true)

##### Mobile version
![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-mobile-15.png?raw=true)


#### Log-out

To log-out, the user just have to click the **LOG-OUT** option in the navigation bar or in the burger menu on mobile. 


#### Password edition

##### Desktop version

![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-desktop-15.png?raw=true)

##### Mobile version

![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-mobile-11.png?raw=true)

#### Question asking

To ask a question, the user can click the **ASK** option in the navigation bar.

##### Desktop version

![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-desktop-5.png?raw=true)

##### Mobile version

![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-mobile-5.png?raw=true)


#### Question answering

There are two ways for a user to answer a question:
- click **Answer** in the nav bar, and select a question to answer in the list
- use function **Search** function and select a question in the results. 
If the list of questions is empty, this means that no body hasked any question about the specific skill choosen by the user in its profile.

The questions list can here be **sorted by date**, and is there is more than three questions to display, a **pagination system** appears.

##### Desktop version

![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-desktop-7.png?raw=true)
![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-desktop-8.png?raw=true)

##### Mobile version

![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-mobile-16.png?raw=true)
![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-mobile-7.png?raw=true)

#### Profile display

The user can click on its profile picture to display its profilte. In this page, the users accesses all the questions he asked, and the answered he posted.
Questions and answers are grouped in two tabs.

From the profile, the user can also access the password edition option.

The account deletion function here hasn't been implemented.

##### Desktop version

![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-desktop-9.png?raw=true)
![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-desktop-10.png?raw=true)

##### Mobile version

![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-mobile-10.png?raw=true)
![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-mobile-9.png?raw=true)


#### Question research by key words

The user can type a key word in the search bar to find a related quesitons. The query return results from both question titles and descriptions.

##### Desktop version

![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-desktop-12.png?raw=true)

##### Mobile version

![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-mobile-8.png?raw=true)


#### 404 Error

Any 404 error from the web site returns the following page:

##### Desktop version

![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-desktop-13.png?raw=true)

##### Mobile version

![screen capture](https://github.com/0reldev/share-my-brain/blob/dev/src/main/resources/static/images/screen-captures/screen-capture-mobile-12.png?raw=true)
