# Introduction to Git Recap | Learn with Dr G


###
```bash

#
git config --list

#
git init

# -a all modified files
git commit -a -m "The message with the commit changes"

#
git log --oneline
```

### .gitignore file
```bash
# on .gitinore backup files
.back 

# ignore the temporary files
*~
```

### 
```bash
# add to the tracking all new files
git add -A


# a shortcut for commit instead of -a -m
git commit -am "The message in the commit"

# to track a folder use the .git-keep file

# when you fix a typo and you dont want to change the previous commit message.
git commit --amend --no-edit


# to recover a file deleted
git checkout -- index.html


# to delete and stop tracking a file
git rm index.html

```



## RESOURCES

- [Introduction to Git Recap | Learn with Dr G](https://www.youtube.com/watch?v=9uGS1ak_FGg)