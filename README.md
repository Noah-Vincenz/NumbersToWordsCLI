# Numbers to words generator

This project contains a command-line interface (CLI) tool that takes an integer from 0 to 100,000 and converts it into grammatically correct English words.
For example, `12345` will be transformed to `twelve thousand, three hundred and forty-five`.

## Run CLI

Once the project repository has been unzipped, open a new terminal window and execute 
```
./bin/numbers-to-words <your_input_number>
```
where `your_input_number` represents the number you would like to be transformed.

## Edit project code

This project uses Java 17. In order to edit the project code, you should first execute
```
mvn clean install
```
to install any dependencies using Maven. You can now edit any files or run the unit tests using an IDE.

## Decisions made

### Why bash
- separating input validation from functionality
- CLI + exit codes
- bash if flexible, available everywhere, virtually on every machine (also Windows)

## Future improvements
- add std err instead of exit codes only
- move bash script validation into Java code to make testable as single unit and allow for integration testing
