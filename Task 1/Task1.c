#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function to identify whether each line is a comment or not
void line_identifier(const char* filename) {
    FILE* file = fopen(filename, "r");
    if (file == NULL) {
        perror("Error opening file");
        exit(EXIT_FAILURE);
    }

    char line[1000];
    int line_number = 0;

    while (fgets(line, sizeof(line), file) != NULL) {
        line_number++;
        char* stripped_line = strtok(line, "\r\n");

        if (stripped_line != NULL && (stripped_line[0] == '#' || (stripped_line[0] == '/' && stripped_line[1] == '/'))) {
            printf("Line %d: Comment - %s\n", line_number, stripped_line);
        } else {
            printf("Line %d: Code - %s\n", line_number, stripped_line);
        }
    }
    fclose(file);
}

int main() {
    const char* filename = "code.txt";
    line_identifier(filename);
    return 0;
}