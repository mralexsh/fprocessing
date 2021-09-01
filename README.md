## Handling files with Apache Camel

### The task
Suppose we have a folder which contains some sort of files. Let's call it input folder. 
Each file is a JSON file, and it must be recognized by JSON schema as valid or invalid one.
Every time a file occurred in the input folder it must be serialized and enriched with some 
additional information from database. Then we need to put it to output folder and remove it
from the input folder.