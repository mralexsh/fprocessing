## Handling files with Apache Camel

### The task
Suppose we have a folder that contains files. Let's call it the input folder. Each file is a JSON file, and it must be recognized that the JSON schema is valid or invalid. Every time a file occurs in the input folder, it must be serialized and enriched with additional information from a database. Then we need to put it in the output folder and remove it from the input folder.
