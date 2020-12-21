package tests_generators.utils.enums;

public class CharactersUtils {

    public static String characterToString(String character) {
        switch (character) {
            case "/" -> {
                return "Slash";
            }
            case ";" -> {
                return "Semicolon";
            }
            case "~" -> {
                return "Tilde";
            }
            case "!" -> {
                return "Exclamation";
            }
            case "@" -> {
                return "Strudel";
            }
            case "#" -> {
                return "Hashtag";
            }
            case "$" -> {
                return "Dollar";
            }
            case "%" -> {
                return "Percentage";
            }
            case "^" -> {
                return "Power";
            }
            case "&" -> {
                return "Ampersand";
            }
            case "*" -> {
                return "Asterisk";
            }
            case "(" -> {
                return "LeftRound";
            }
            case ")" -> {
                return "RightRound";
            }
            case "_" -> {
                return "Underscore";
            }
            case "+" -> {
                return "Plus";
            }
            case "=" -> {
                return "Equal";
            }
            case "-" -> {
                return "Minus";
            }
            case "." -> {
                return "Dot";
            }
            case "?" -> {
                return "Question";
            }
            case "|" -> {
                return "Bar";
            }
            case "\\" -> {
                return "Backslash";
            }
            case "]" -> {
                return "RightSquare";
            }
            case "[" -> {
                return "LeftSquare";
            }
            case "}" -> {
                return "RightCurly";
            }
            case "{" -> {
                return "LeftCurly";
            }
            case "'" -> {
                return "Quote";
            }
            case ">" -> {
                return "Big";
            }
            case "<" -> {
                return "Small";
            }
            case "," -> {
                return "Comma";
            }
            case ":" -> {
                return "Colon";
            }
        }
        return null;
    }

    public static String stringToCharacter(String value) {
        switch (value) {
            case "Slash" -> {
                return "/";
            }
            case "Semicolon" -> {
                return ";";
            }
            case "Tilde" -> {
                return "~";
            }
            case "Exclamation" -> {
                return "!";
            }
            case "Strudel" -> {
                return "@";
            }
            case "Hashtag" -> {
                return "#";
            }
            case "Dollar" -> {
                return "$";
            }
            case "Percentage" -> {
                return "%";
            }
            case "Power" -> {
                return "^";
            }
            case "Ampersand" -> {
                return "&";
            }
            case "Asterisk" -> {
                return "*";
            }
            case "LeftRound" -> {
                return "(";
            }
            case "RightRound" -> {
                return ")";
            }
            case "Underscore" -> {
                return "_";
            }
            case "Plus" -> {
                return "+";
            }
            case "Equal" -> {
                return "=";
            }
            case "Minus" -> {
                return "-";
            }
            case "Dot" -> {
                return ".";
            }
            case "Question" -> {
                return "?";
            }
            case "Bar" -> {
                return "|";
            }
            case "Backslash" -> {
                return "\\";
            }
            case "RightSquare" -> {
                return "]";
            }
            case "LeftSquare" -> {
                return "[";
            }
            case "RightCurly" -> {
                return "}";
            }
            case "LeftCurly" -> {
                return "{";
            }
            case "Quote" -> {
                return "'";
            }
            case "Big" -> {
                return ">";
            }
            case "Small" -> {
                return "<";
            }
            case "Comma" -> {
                return ",";
            }
            case "Colon" -> {
                return ":";
            }
            default -> {
                return value;
            }
        }
    }
}
