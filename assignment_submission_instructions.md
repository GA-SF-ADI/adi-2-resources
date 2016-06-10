## Homework & Lab Submission Instructions

- Run `git status`. If you have any usaved changes, make sure to add them via `git add .` and `git commit -m "Descriptive message"`.
- Run `git status` again and make sure there is **nothing to commit**. 
- Switch to master branch! Use `git checkout master`.
- Create a "hw-day-topic" ( or "lab-day-topic" ) branch using: `git checkout -b hw-1-variables`. Remember `git chekout -b` will create the new branch **and switch to it**.
- Do you homework inside of the appropriate `week/day/homework` folder. 
- **Make sure to commit often!**
- After you are done with your homework, double check that your git is fully up to date by running `git status`. Commit any unsaved changes.
- Push your homework branch ( using a branch named "hw-1-variables" for this example ) to remote using `git push origin hw-1-variables`.
- Open up github.com in your web browser and navigate to **your forked** `adi-2-resources` repository. Make sure to hit refresh. Your screen should look like the image below:
![](pull_request_example.png)

- Click on the `Compare & Pull Request` button!
- Your screen should now look like this:
![](creating_pull_request.png)
- For the **Title**: enter your **name**, **homework day and homework topic** like so: `Alex - Hw 1 - variables`.
- In the **comment** section, please talk about your experience with the homework. Whether it was easy or hard. Whether you need more help with a certain topic or the instructions were not clear, etc.
- Press the `Create Pull Request Button`. You will be taken to your pull request screen on the **original** `adi-2-resources` repository. If you scroll down there is a comments section, that is where feedback will be given. Right on your pull request.
- Finally, don't forget to `git checkout master` so you can create new branches other homeworks/labs.
