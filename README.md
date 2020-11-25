
# A Tool extracting statistics from java ASTs (Abstract Syntax Trees)

> A java program that recursively processes java source code and extract statictics

## Installing / Getting started

```shell
git clone https://github.com/sellisd/javacodeseq.git
./gradlew run --args='--help' # to see the available arguments
./gradlew run --args='--input input_path/ --output output_file.tsv' # to see the available arguments
```

All `.java` files under `input_path` will be scanned and a number of metrics will be written to `output_file.tsv` in a tab-delimited format. The columns in the output file are:

- `class`: Name of class
- `class_lines`: Total number of lines of code included in the class
- `method`: Name of method
- `method_lines`: Total number of lines of code included in the class
