# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Project #3: Yelp -- New Local Experiences App

#### Overview

Project 3 is your opportunity to really let your creativity shine! You will have the basic app requirements, provided by Yelp, but it is up to you to design everything. For this project, your job will be to build an Android app that enables users to discover great local businesses in fun, new ways. The big idea is to create a sense of serendipity and delight for users, ideally including a social component. Here are some ideas for your app:

- Employ gamification to find the best local business (tacos/Italian/bars/etc.)
- Deliver recommendations for an amazing night out when attending a concert or show
- Drive Eat24 food orders and/or SeatMe reservations through an embeddable widget
- Deliver Yelp recommendations through a messaging experience

**You will be working in groups for this project**. The project will be spread across **three weeks**, with separate deliverables due at the end of each week. Although the deliverables will be separate, we will be incorporating them all into a single app, expanding upon the previous week's work. The first week will focus on the research; the second week on your group's project proposal, synthesis from your research, and a basic UI; and the third week on the technical implementation - integrating the various APIs, design and functionality together.

---

#### Requirements / Constraints

Your work must:

- Include at least 2 prototypes
- Include user stories based on your research and feature prioritization in a Trello board for the complete flow of your app
- Call the Yelp API (see below for a full list of available endpoints and categories), which provides access to a large subset of Yelp’s content in JSON format, including a review snippet, review or business thumbnail, business name, address, phone number, star rating, number of reviews, and much more
- Allow the user to quickly view businesses and, as a result, opportunities for discovery, through a richly visual and geographically-relevant presentation
- Adhere to Yelp’s [Display Requirements](https://www.yelp.com/developers/display_requirements) and [Terms of Use](https://www.yelp.com/developers/api_terms)
- Give your app a new, interesting twist by creating a mashup with at least one other API. APIs you might consider using include:
  - Facebook
  - Twitter
  - Twilio
  - Pinterest
  - Airbnb
  - Uber/Lyft
- Look great in both landscape and portrait modes and reflect material design principles
- Not crash or hang and should handle for when networking/internet is slow or unavailable
- Include at least one Notifications or Push feature (e.g. reminders for when users have made a new discovery)

**Bonus:**

- Integrate with a mapping and/or navigation API
- Integrate with a messaging/communication API such as Slack
- Focus on businesses which provide food delivery via Yelp Eat24 or table reservations through Yelp SeatMe
- Allow the user to save, bookmark, or ‘like’ a new discovery from within the app (for clarity: this does not mean creating or posting content on Yelp via the API, but rather standalone functionality built into your app)

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
- Automated tests for your code

---

#### Suggested Ways to Get Started

Visit http://yelp.com/developers and apply for API access [here](https://www.yelp.com/login?return_url=/developers/manage_api_keys) using a Yelp user account.

- Think about a user experience which doesn’t create already-available Yelp functionality.
- Complete as much of the layout as possible before working on your logic.
- Write pseudocode before you write actual code.  Thinking through the logic helps.
- Test functionality as soon as you complete it.

---

### Useful Resources

- [Documentation](https://www.yelp.com/developers/documentation/v2/overview)
- [Display requirements](https://www.yelp.com/developers/display_requirements)
- [Code samples](https://www.yelp.com/developers/documentation/v2/examples)
- [API Console](https://www.yelp.com/developers/api_console)
- [Full list of API errors](https://www.yelp.com/developers/documentation/v2/errors)
- [FAQ](https://www.yelp.com/developers/faq) & [GitHub](https://github.com/Yelp/yelp-api/issues)
- [Terms of Use](https://www.yelp.com/developers/api_terms)

### Full List of Yelp API endpoints


| Endpoint URL | HTTP method | Functionality |
|---|---|---|
| /v2/search | GET | Search for local businesses. |
| /v2/business/{id} |	GET | Lookup business information by id. |
| /v2/phone_search | GET | Search for businesses by phone number. |

### Full List of Yelp Categories
Please refer to Yelp’s [full category list here](https://www.yelp.com/developers/documentation/v2/all_category_list), as well as the [full neighborhood list](https://www.yelp.com/developers/documentation/v2/neighborhood_list). They’re much too extensive to place in this brief!

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
