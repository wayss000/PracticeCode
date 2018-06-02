#!/bin/bash

cd /home/wayss/git-resp/PracticeCode

export current=`date "+%Y-%m-%d"`

for i in {1..5}
    do
        export resultStr=${current}
        echo ${resultStr} >> /home/wayss/git-resp/PracticeCode/auto-commit/content.txt
        git add /home/wayss/git-resp/PracticeCode/auto-commit/content.txt
        git commit -m "Only For Sth."
    done

git push
