import java.util.*;
class NoOfAtoms{
    // Global variable
    int index = 0;

    public String countOfAtoms(String formula) {
        // Recursively parse the formula
        Map<String, Integer> finalMap = parseFormula(formula);

        // Sort the final map
        TreeMap<String, Integer> sortedMap = new TreeMap<>(finalMap);

        // Generate the answer string
        StringBuilder ans = new StringBuilder();
        for (String atom : sortedMap.keySet()) {
            ans.append(atom);
            if (sortedMap.get(atom) > 1) {
                ans.append(sortedMap.get(atom));
            }
        }

        return ans.toString();
    }

    // Recursively parse the formula
    private Map<String, Integer> parseFormula(String formula) {
        // Local variable
        Map<String, Integer> currMap = new HashMap<>();

        // Iterate until right parenthesis or end of the formula
        while (index < formula.length() && formula.charAt(index) != ')') {
            // If left parenthesis, do recursion
            if (formula.charAt(index) == '(') {
                index++;
                Map<String, Integer> nestedMap = parseFormula(formula);
                for (String atom : nestedMap.keySet()) {
                    currMap.put(
                        atom,
                        currMap.getOrDefault(atom, 0) + nestedMap.get(atom)
                    );
                }
            }
            // Otherwise, it should be UPPERCASE LETTER
            // Extract the atom and count in one go.
            else {
                StringBuilder currAtom = new StringBuilder();
                currAtom.append(formula.charAt(index));
                index++;
                while (
                    index < formula.length() &&
                    Character.isLowerCase(formula.charAt(index))
                ) {
                    currAtom.append(formula.charAt(index));
                    index++;
                }

                StringBuilder currCount = new StringBuilder();
                while (
                    index < formula.length() &&
                    Character.isDigit(formula.charAt(index))
                ) {
                    currCount.append(formula.charAt(index));
                    index++;
                }

                if (currCount.length() == 0) {
                    currMap.put(
                        currAtom.toString(),
                        currMap.getOrDefault(currAtom.toString(), 0) + 1
                    );
                } else {
                    currMap.put(
                        currAtom.toString(),
                        currMap.getOrDefault(currAtom.toString(), 0) +
                        Integer.parseInt(currCount.toString())
                    );
                }
            }
        }

        // If the right parenthesis, extract the multiplier
        // and multiply the count of atoms in the curr_map
        index++;
        StringBuilder multiplier = new StringBuilder();
        while (
            index < formula.length() && Character.isDigit(formula.charAt(index))
        ) {
            multiplier.append(formula.charAt(index));
            index++;
        }
        if (multiplier.length() > 0) {
            int mult = Integer.parseInt(multiplier.toString());
            for (String atom : currMap.keySet()) {
                currMap.put(atom, currMap.get(atom) * mult);
            }
        }

        return currMap;
    }
}