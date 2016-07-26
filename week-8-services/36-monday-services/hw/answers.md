What is the difference between an IntentService , a regular Service and a BoundedService ?


An intentService is used when one task is run and you don't need to interact with it. IntentService is meant for a single task and destroys itself after the task is completed. It also sets up it's own thread.  A regular service can be binded and allows for interaction.  You can get results from the service as it comes in. A binded service runs as long as it is binded to an activity. 

What are three examples in apps that you use that you think are using a Service? downloading a song, uploading a picture, playing a song in the background.