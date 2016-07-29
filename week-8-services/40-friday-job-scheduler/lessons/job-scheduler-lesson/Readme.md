---
title: Job Scheduler
duration: "1:20"
creator:
    name: Jamey Hollis
    city: SF
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Job Scheduler


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Define what a JobScheduler is
- Set up and use a JobService

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Describe Content Providers

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and solution code to ensure it's working and that you agree with how the code was written

---
<a name="opening"></a>
## Opening (5 mins)

So far we've been able to incorporate a lot of really cool features into our apps, including sending and receiving data from our device. This is very useful with today's constantly connected world. Unfortunately, we've had to do all of this manually, so far. 
Luckily, Android provides a very handy feature called the `JobScheduler` that works to run various Jobs following a given schedule!


***

<a name="introduction"></a>
## Introduction: What is a JobScheduler/JobService (15 mins)

Basically, the `JobScheduler` is an API in the Android Framework that lets you schedule jobs that can run inside your application. It is a system service that is used but not created, edited or extended. 

Here are some key features Job Scheduler have (from the Android documentation):

- **Automated execution** - Allows you to automate data transfer based on a variety of criteria, including elapsed time, or time of day. In addition, the system adds transfers that are unable to run to a queue, and runs them when possible.
- **Automated checking** - The system only runs your data transfer when the device has network connectivity or is plugged in, etc. 
- **Improved battery performance** - Allows you to centralize all of your app's data transfer tasks in one place, so that they all run at the same time. Your data transfer is also scheduled in conjunction with data transfers from other apps. These factors reduce the number of times the system has to switch on the network, which reduces battery usage.


There are two steps to properly using the `JobScheduler`. The first is creating a `JobInfo` object which gives you the specification of the job. The second is creating your `JobService`, which is a `Service` where the actually execution of the job will be run.  

<a name="JobInfo"></a>
## Setting up the JobInfo (20 mins)

Creating you instance of a JobInfo object is a pretty simple 

``` 
JobInfo job = new JobInfo.Builder( 1, 
        new ComponentName( getPackageName(),
            ExampleJobService.class.getName()))  //the name of the JobService you will eventually create 
            .setPeriodic(40000) //The period that you want your jobbuilder to run on
            .build();
```

ASIDE: This code is could  give you an error telling you that the call requires API 21. This is because JobScheduler was introduced in Lollipop and older APIs cannot use the methods. You can get rid of this error in one of two ways: adding the ` @TargetApi(21) `annotation above the method you are creating your job info in or creating an if statement to check if the current version is 21. 


Lets break down the lines 

#### Step 1

` JobInfo job = new JobInfo.Builder( JOB_ID, `

This line is doing two things. The first is it is declaring our JobInfo variable. The second is it is starting to create our JobInfo.Builder object. You do not have access to the regular JobInfo constructor so you need to access it through the Builder inner class, similar to how you needed to use a Builder to create a retrofit object. The `JOB_ID` variable is simply an int you give your jobs so you can access them later. In this case we are assuming that the developer has previously declared a JOB_ID static final variable at the top of their activity. 


#### Step 2

        new ComponentName( getPackageName(),   

The JobInfo.Builder constructor requires two parameters. The first is the id that we passed in in the step before. The second is a ComponentName object, which is a class that android gives us that giveds specific information about components (Activities, Services, BroadcastRecievers, etc), of an application. We need to specify this in our `JobInfo` object so when the scheduled job gets executed the OS knows where to find our code. 

The important thing to know is that your ComponentName constructor takes in two parameters, the first is the package name of your application which you can get by running the getPackageName() method, the second is the class name that we will use in the next line.  

#### Step 3

` ExampleJobService.class.getName())) `

This line is the second part of the ComponentName constructor and the end of your `JobInfo.Builder` constructor (count the end parens and the end to make sure). The second part is the name of your class that contains your `JobService`, a class that you should at least create right now. In order to get that class name, we need to access the static .class variable of your service then run the `getName()` method on that class to actually get the name. Just follow the above steps, it is a simple pattern. 

### Step 4

` .setPeriodic(40000) `

The previous steps were just a pattern that you will need to repeat each time that you want to schedule a job. This step is where you start adding some customizations to our Job. 


There are a variety of methods you can run on your `JobInfo.Builder` object to add information about your job before you schedule it. These include:

- ` setPeriodic(long intervalMillis) ` 
- ` setPersisted(boolean isPersisted) `
- ` setRequiredNetworkType(int networkType) `
- ` setRequiresCharging(boolean requiresCharging) `
- ` setDeviceIdle(boolean deviceIdle) ` 

As a warning, a lot of these methods require that you include certain permissions. For example, the ` setPersisted(boolean isPersisted) ` method requires you to have the `RECIEVE_BOOT_COMPLETED` uses permission in your manifest. 
### Step 5

` .build() `

This is the last step, it finally builds your `JobInfo` object. 


<a name="JobService"></a>
## DEMO: Setting up the JobService (20 mins)

Now that we have our ` JobInfo ` , we need to create our ` JobService ` . To do this we need to use the class we created in Step 3 of creating our job info, in our case, our `ExampleJobService.java` file. This class is going to be a `JobService`, and in order to do that, we need to make sure that it extends ` JobService ` 

``` public class ExampleJobService extends JobService ```


This is a Service, so we have access to the `onStartCommand` and `onDestroy` methods that all Services have, but because this is a JobService the methods we need to implement are different. We need to implement ` onStartJob() ` and ` onStopJob() ` like this

```
    @Override
    public boolean onStartJob(JobParameters params) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

```


There are two interesting things to note about these two methods before we proceed. The first has to do with `onStopJob` is called. It is not like the lifecycle methods `onStop()` or `onPause()` that get called whenever the Activity gets Paused or Stopped. If the Job naturally finishes, `onStopJob()` will not be called. 

The second thing worth noting is the return value of the `onStartJob()` method. Right now, it returns false. That means there isn't any extra work that needs to be done in the Service. 


If you are going to be using an extra thread to carry out more logic, you need to return true so it doesn't close your process

IMPORTANT NOTE: If you are returning true, you should make sure that your logic at some point calls the  ` jobFinished(JobParams params) ` method to make sure that the job gets stopped. 


 Now that we've talked about these methods a lot, lets actually go through and do something with them. Just for an example, lets just have it log out the current time

 ```
    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d("ExampleService", Calendar.getInstance.getTime());
        return false;
    }

```

Thats all the code we need inside our ` JobService ` but remember, it is a Service, so you need to declare it in your Manifest! 

```

<service android:name=".ExampleJobService"
        android:permission="android.permission.BIND_JOB_SERVICE"
        ></service>

```

Notice how we need the BIND_JOB_SERVICE permsission. We need that if we want to be able to use our service as a JobService!
After doing that, there is now just one last step to take: scheduling our job! 

<a name="JobScheduler"></a>
## Getting the JobScheduler  10 Minutes

This following code happens back in our `MainActivity`, right after where we made our job. 

```
        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
```

Remember, the JobScheduler class is not something you manipulate or extend off of yourself. It is a given SystemService that you can use to talk to Android's JobManager in order to do stuff for you. This means instead of making a new JobScheduler(which you can't do) you instead need to get it by using the ` Context.getSystemService(String name) ` method. The name it takes is the static `Context.JOB_SCHEDULER_SERVICE ` variable. 

Now that we have our JobScheduler object, our JobInfo object, and a built JobService class, we just need to schedule the job

```
int result = jobScheduler.schedule(jobInfo);
if(result <= 0){
    //stuff went wrong
}
```

It is good practice to get back the result of the jobScheduler.schedule method as it returns a result about whether or not it was properly able to schedule the job. Simply check if the result is <= 0, and if it is, something went wrong and you need to handle the problem. Make a toast maybe, just inform the user something didn't go as planned. 

Other than that, viola, job is fully scheduled!

<a name = "Guided Practice"></a>
## Guided Practice 15 Minutes

Lets go through all of those steps together! 

<a name = "Cancelling Jobs"></a>
## Cancelling Jobs

So now we've gone through and created our job and it is ticking along as expected. The problem now is that it is going to be constantly running this on the emulator until the end of time. If only there were a way to cancel a Job!

Oh wait, there is, with the handy dandy `cancelJob(int jobId)` method! 

```
jobScheduler.cancelJob(JOB_ID);
```

That's all there is to it. You can cancel the job based off of the id that you used to create your job!3


<a name = "Independent Practice"></a>
## Independant Practice

Now its time for you to do some practice. Find the NotificationJobService  starter code and complete the TODOs to make a Job that sends a notification every ten seconds! Try to make it persist through you launching your phone!  

<a name="conclusion"></a>
## Conclusion (5 mins)

Job Schedulers and Job Services are very useful for running code at given times. They are useful for sending notifications, making API calls, or setting up any type of repeated task. Feel free to use them in the coming weeks! 


***

