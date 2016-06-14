#!/bin/bash
# Script to transform teacher directories to student directories


echo "Deleting instructor comments and checks"
find . -type f -name 'readme.md' -print0 | xargs -0 sed -i '' '/^>/ d'

