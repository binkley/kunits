# Robert Units of Measure for Lengths

Please edit the table below, and rerun the build with `./mvnw clean install` to
generate a new version of the library as you add/remove/edit length units.

Here's what happens when you run the build:
- This Markdown file is read to find your unit definitions.
- Your "system" name and "kind" type are turned into something like
   "SystemKinds". For example, "robert" and "length" become "RobertLengths" in
   the generated code.
- Your "base_unit" column defines what the "value of 1" unit is for your
   measure; all other units for this system and kind are relative to this base
   unit.
- Each unit row (eg, "bobbub", "bob head") turns into:
    - Natural names (eg, "bob head") become a camelcase class names (eg,
      "BobHead") and a companion factory class (eg, "BobHeads").
    - Typical numeric types get an extension property for conversion to your
      unit (eg, `2.bobheads`).
      These include any aliases you listed (eg, `2.bobberts` becomes a unit of
      two bobbubs).
- You get a `RobertLengths.kt` file generated in
   `target/generated-sources/ksp/hm/binkley/kunits/system/robert/length/` with
   all of the above code.

Additional notes:
- The base unit is "bob"; all `value_of_base_unit` values are relative to it.
- Use natural names (e.g., "bob head") in `name_singular` and `name_plural`; the
   build converts them to camel case.
- Add aliases in the `aliases` column, separated by commas, also in natural
   form.
- Leave cells blank where not applicable.


## The table of units

| system | kind   | base_unit | value_of_base_unit | name_singular | name_plural | printed_singular | printed_plural | aliases  |
|--------|--------|-----------|--------------------|---------------|-------------|------------------|----------------|----------|
| robert |        |           |                    |               |             |                  |                |          |
|        | length | bob       |                    | bob           | bobs        | 1 bob            | 1 bobs         |          |
|        |        |           | 1/24               | bobbub        | bobbubs     | 1 bobbub         | 2 bobbubs      | bobberts |
|        |        |           | 2                  | bob head      | bob heads   | 1 bobhead        | 2 bobheads     |          |
 