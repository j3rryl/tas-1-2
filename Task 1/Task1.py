def line_identifier(lines):
    result = []

    for line in lines:

        stripped_line = line.strip()

        if stripped_line.startswith('#') :
            result.append("Comment")
        else:
            result.append("Not a Comment")

    return result

filename = "code.txt"
with open(filename, "r") as file:

    lines = file.readlines()
line_types = line_identifier(lines)
for i, line in enumerate(lines):

    print(f"Line {i + 1}: {line_types[i]} - {line.strip()}")