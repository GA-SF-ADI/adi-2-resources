# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Project #3: Vice Visual News App

#### Overview

Project 3 is your opportunity to really let your creativity shine! You will have the basic app requirements, provided by Vice, but it is up to you to design everything. This app will allow the user to browse Vice's news articles using a photo-based interface.

**You will be working in groups for this project**. The project will be spread across **three weeks**, with separate deliverables due at the end of each week. Although the deliverables will be separate, we will be incorporating them all into a single app, expanding upon the previous week's work. The first week will focus on the research; the second week on your group's project proposal, synthesis from your research, and a basic UI; and the third week on the technical implementation - integrating the various APIs, design and functionality together.


---

#### Requirements / Constraints

Your work must:

- Include **at least 2 prototypes**
- Include user stories based on your research and feature prioritization in a Trello board for the **complete flow of your app**
- Hit [the Vice API](http://www.vice.com/en_us/api/getlatest/0) (see below for a full list of available endpoints and categories), which provides access to all of Vice's latest stories in JSON format, including photo thumbnails for each story
- Allow the user to browse through Vice's news articles using an interface that is photo-based, rather than text-based ([Flipboard](https://flipboard.com/) is one example of what your app could look like)
- Allow the user to click on a photo and read the article to which the photo relates
- Provide the user with some mechanism by which to filter stories based on one or more of the following:
  - Keywords
  - Tags
  - Topics
  - Location

- Integrate with the Twitter and/or Facebook's APIs
- Allow the user to share individual photos and stories via social media
- Look great in both landscape and portrait modes and reflect Material Design principles
- Not crash or hang and should handle for when networking/internet is slow or unavailable
- Include at least one Notifications feature (e.g. reminder, alarm)


**Bonus:**

- Integrate additional APIs
- Allow the user to download photos, manipulate them by adding text, etc. (image manipulation libraries will probably be helpful here...) and then share their manipulated image via social media


---

#### Code of Conduct

As always, your app must adhere to General Assembly's [student code of conduct guidelines](../../../resources/guidelines/code-of-conduct.md).

If you have questions about whether or not your work adheres to these guidelines, please speak with a member of your instructional team.

---

#### Necessary Deliverables

**Week 7:**

By the end of week 7:

- A completed research plan according to the template provided in class
- Competitive research in a Google Sheet

**Week 8:**

By the end of week 8:

- Written user personas--ideally from both new and longtime Yelp user perspectives
- A list of prioritized features
- A project plan presentation
- Completed user stories
- A link to your team's Trello Board set up according to [Trello's suggestions](http://buildbettersoftware.com/with-trello/)
- A **completed, basic version of the user interface for your app**, with placeholder data and resources to fill out your screens

**Week 9:**

By the end of week 9:

- Working cloud synchronization using Sync Adapters and API integration
- A final, working version of your app
- A **git repository hosted on GitHub**, with frequent commits dating back to the **very beginning** of the project. Commit early, commit often
- **A ``readme.md`` file** describing what the app does, and any bugs that may exist
- One screenshot in the ``readme.md``
- Automated tests for your code---

#### Suggested Ways to Get Started

- Complete as much of the layout as possible before working on your logic.
- Write pseudocode before you write actual code. Thinking through the logic helps.
- Test functionality as soon as you complete it.  

---

### Useful Resources

- [Android API Reference](http://developer.android.com/reference/packages.html)
- [Android API Guides](http://developer.android.com/guide/index.html)
- [Creating a Sync Adapter](http://developer.android.com/training/sync-adapters/creating-sync-adapter.html)
- [Twitter for Developers](https://dev.twitter.com/)
- [Facebook for Developers](https://developers.facebook.com/)

### Full List of Vice API endpoints

- http://vice.com/api/getvicetoday/<:page>
  - page: integer
  - returns items from the vice today feed
- http://vice.com/api/getmostpopular/<:page>
  - type: string (‘video’ | ‘blog’)  video for videos, blog for text and gallery
  - returns items for the most popular feed by type
- http://vice.com/api/getmostpopular/<:type>/<:page>
  - page: integer
  - type: string (‘video’ | ‘blog’)  video for videos, blog for text and gallery
  - returns items for the most popular feed by type
- http://vice.com/api/getlatest/<:page>
  - page: integer
  - returns items ordered by publish date
- http://vice.com/api/getlatest/category/<:category>/<:page>
  - category :string
  - available categories listed below
  - :page integer
  - returns items by category ordered by publish date
- http://vice.com/api/getlatest/<:type>/<:page>
  - type: string (‘blog’ | ’video’ | ’gallery’ | ’dos-and-donts’)
  - blog for text, video for video, gallery for gallery, and dos-and-donts for DnDs
  - page: integer
  - returns items by article type ordered by publish date
- http://vice.com/api/getepisodeparts/<:id>
  - id: integer - ID of an article
  - returns all OTHER articles in the given article’s episode if it associated with an episode
- http://vice.com/api/article/<:id>
  - id: integer - ID of an article
  - returns all api data for the given article including other episode parts if applicable
- http://vice.com/api/series/<:id>/<:page>
- id: integer - ID of a series (show or column)
  - page: integer
  - returns all articles within a given series
- http://vice.com/api/getallshows/<:page>
  - page: integer
  - returns a list of show series
- http://vice.com/api/getallcolumns/<:page>
  - page: integer
  - returns a list of column series

### Full List of Vice Categories
  news, music, sports, tech, travel, fashion, guide, nsfw, photo, comics, stuff, film, festivals, gallery, noisey, thecreatorsproject, fightland, motherboard, food, interviews, culture, column

---

#### Project Feedback + Evaluation


Base on the requirements you can earn a maximum of 27 points on this project. Your instructors will score each of your technical requirements using the scale below:

    Score | Expectations
    ----- | ------------
    **0** | _Incomplete._
    **1** | _Does not meet expectations._
    **2** | _Meets expectations, good job!_
    **3** | _(If applicable) Exceeds expectations, you wonderful creature, you!_

 This will serve as a helpful overall gauge of whether you met the project goals, but __the more important scores are the individual ones__ above, which can help you identify where to focus your efforts for the next project!
