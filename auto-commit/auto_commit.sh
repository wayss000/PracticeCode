#!/bin/bash

cd /home/wayss/git-resp/PracticeCode

export current=`date "+%Y-%m-%d %H:%M:%S"`

for i in {1..3}
    do
        export resultStr=${current}"   -${i}"
        echo ${resultStr} >> /home/wayss/git-resp/PracticeCode/auto-commit/content.txt
        git add /home/wayss/git-resp/PracticeCode/auto-commit/content.txt
        git commit -m "Only For *"
    done

git push
