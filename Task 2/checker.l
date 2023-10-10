%{
#include <stdio.h>
%}

/* Reserved words
 Numbers can be identifiers */
%%

"int"|"for"|"if"|"string"|"new"   { printf("Invalid identifier: Reserved word used.\n"); }
[a-zA-Z_][a-zA-Z0-9_]*    { printf("Valid identifier.\n"); }
.                        { printf("Invalid identifier.\n"); }

%%

int main(void) {
    yylex();
    return 0;
}

int yywrap() {
    return 1;
}
