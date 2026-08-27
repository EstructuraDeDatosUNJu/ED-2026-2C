package ed2026.TP2;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Realizar un programa que permita al usuario ingresar cualquier cantidad de caracteres. Una vez cargado el
arreglo, el programa debe:
a)​ Obtener la cantidad de caracteres que aparecen más de una vez (duplicados), sin distinguir entre
mayúsculas y minúsculas. Asimismo, mostrar cuáles son esos caracteres.
b)​ Buscar y mostrar la posición de la primera vocal y la última consonante encontrada en el arreglo.
c)​ Obtener un nuevo arreglo que contenga únicamente los caracteres que son dígitos numéricos (del '0' al
'9'). Mostrar el arreglo resultante.
d)​ Intercambiar la posición del primer carácter encontrado que sea una letra mayúscula con el último
carácter que sea un símbolo (no letra ni número). Si no hay mayúsculas o no hay símbolos, generar un
número aleatorio (entre 0 y la longitud-1) y usar el carácter de esa posición para el intercambio.
Mostrar el arreglo modificado.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
 * Tp2_03
 */

public class Tp2_03 {
    public static void main(String[] args) {

        ArrayList<Character> characters = new ArrayList<>();
        ArrayUtils.loadArrayListCharacterFromConsole(characters, "Ingrese un caracter");
        ArrayUtils.showArrayListCharacter(characters, "Los caracteres ingresados son: ");
        getCharactersRepeated(characters);
        System.out.println("La posicion de la primera vocal es: " + getPositionalFirstVowel(characters));
        System.out.println("La posicion de la ultima consonante es: " + getPositionalLastConsonant(characters));
        ArrayList<Character> charactersDigitsNumbers = getCharactersDigitsNumbers(characters);
        ArrayUtils.showArrayListCharacter(charactersDigitsNumbers, "Los caracteres que son digitos son: ");
        swapFirstUppercaseAndLastSymbol(characters);
        ArrayUtils.showArrayListCharacter(characters, "\nEl arreglo modificado es: ");
    }

    /**
     * Metodo que intercambia la primera letra mayuscula con el ultimo simbolo de un arreglo de caracteres
     * @param characters arreglo de caracteres
     */
    public static void swapFirstUppercaseAndLastSymbol(ArrayList<Character> characters) {
        if (characters.isEmpty()) {
            System.out.println("\nThe array is empty; the swap cannot be performed.");
            return;
        }

        int uppercasePosition = findFirstUppercasePosition(characters);
        int symbolPosition = findLastSymbolPosition(characters);
        int randomIndex = randomPosition(characters.size());

        if (uppercasePosition == -1) {
            uppercasePosition = randomIndex;
        }
        if (symbolPosition == -1) {
            symbolPosition = randomIndex;
        }

        Character temporary = characters.get(uppercasePosition);
        characters.set(uppercasePosition, characters.get(symbolPosition));
        characters.set(symbolPosition, temporary);
    }

    /**
     * Metodo que encuentra la posicion de la primera letra mayuscula en un arreglo de caracteres
     * @param characters arreglo de caracteres
     * @return posicion de la primera letra mayuscula, o -1 si no se encuentra
     */
    public static int findFirstUppercasePosition(ArrayList<Character> characters) {
        for (int idx = 0; idx < characters.size(); idx++) {
            if (Character.isUpperCase(characters.get(idx))) {
                return idx;
            }
        }
        return -1;
    }

    /**
     * Metodo que encuentra la posicion del ultimo simbolo en un arreglo de caracteres
     * @param characters arreglo de caracteres
     * @return posicion del ultimo simbolo, o -1 si no se encuentra
     */
    public static int findLastSymbolPosition(ArrayList<Character> characters) {
        for (int idx = characters.size() - 1; idx >= 0; idx--) {
            if (isSymbol(characters.get(idx))) {
                return idx;
            }
        }
        return -1;
    }

    /**
     * Metodo que valida si un caracter es un simbolo
     * 
     * @param character caracter a validar
     * @return true si el caracter es un simbolo, false si no lo es
     */
    public static boolean isSymbol(char character) {
        return !Character.isLetter(character) && !Character.isDigit(character);
    }

    /**
     * Metodo que obtiene una posicion aleatoria dentro del rango del arreglo
     * 
     * @param length tamaño del arreglo
     * @return posicion aleatoria dentro del rango del arreglo
     */
    public static int randomPosition(int length) {
        return ThreadLocalRandom.current().nextInt(length);
    }

    /**
     * Metodo que obtiene los caracteres repetidos y su cantidad de repeticiones
     * 
     * @param arrayListCharacters arreglo de caracteres
     */
    public static void getCharactersRepeated(ArrayList<Character> arrayListCharacters) {
        ArrayList<Integer> quantityCharactersRepeated = new ArrayList<>();
        ArrayList<Character> charactersRepeated = new ArrayList<>();
        int quantityCharacterRepeted;
        for (int idx = 0; idx < arrayListCharacters.size(); idx++) {
            if (!characterRepeated(charactersRepeated, arrayListCharacters.get(idx))) {
                quantityCharacterRepeted = getQuantiyCharacterRepeated(arrayListCharacters,
                        arrayListCharacters.get(idx));
                if (quantityCharacterRepeted > 1) {
                    quantityCharactersRepeated.add(quantityCharacterRepeted);
                    charactersRepeated.add(arrayListCharacters.get(idx));
                }
            }
        }
        ArrayUtils.showArrayListCharacterAndInteger(charactersRepeated, quantityCharactersRepeated,
                "El caracter: ", " se repite: ");
    }

    /**
     * Metodo que valida si un caracter esta repetido en un arreglo de caracteres
     * 
     * @param arrayCharacterRepeated arreglo de caracteres
     * @param character              caracter a validar
     * @return true si el caracter esta repetido, false si no lo esta
     */
    public static boolean characterRepeated(ArrayList<Character> arrayCharacterRepeated, char character) {
        if (arrayCharacterRepeated.isEmpty()) {
            return false;
        }
        for (int idx = 0; idx < arrayCharacterRepeated.size(); idx++) {
            if (areCharactersIqual(arrayCharacterRepeated.get(idx), character)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que obtiene la cantidad de veces que un caracter se repite en un
     * arreglo de caracteres
     * 
     * @param arrayCharacter arreglo de caracteres
     * @param character      caracter a validar
     * @return cantidad de veces que el caracter se repite en el arreglo
     */
    public static int getQuantiyCharacterRepeated(ArrayList<Character> arrayCharacter, char character) {
        int quantityCharacter = 0;
        for (int idx = 0; idx < arrayCharacter.size(); idx++) {

            if (areCharactersIqual(arrayCharacter.get(idx), character)) {
                quantityCharacter++;
            }
        }
        return quantityCharacter;
    }

    /**
     * Metodo que valida si dos caracteres son iguales
     * 
     * @param character1 primer caracter
     * @param character2 segundo caracter
     * @return true si los caracteres son iguales, false si no lo son
     */
    public static boolean areCharactersIqual(char character1, char character2) {
        return Character.toLowerCase(character1) == Character.toLowerCase(character2);
    }

    /**
     * Metodo que valida si un caracter es una vocal
     * 
     * @param character caracter a validar
     * @return true si el caracter es una vocal, false si no lo es
     */
    public static boolean isVowel(char character) {
        return "aeiou".indexOf(Character.toLowerCase(character)) != -1;
    }

    /**
     * Metodo que valida si un caracter es una consonante
     * 
     * @param character caracter a validar
     * @return true si el caracter es una consonante, false si no lo es
     */
    public static boolean isConsonant(char character) {
        return Character.isLetter(character) && !isVowel(character);
    }

    /**
     * Metodo que obtiene la posicion de la primera vocal de un arreglo de caracteres
     * 
     * @param arrayCharacter arreglo de caracteres
     * @return la posicion de la primera vocal del arreglo, -1 si no hay vocales
     */
    public static int getPositionalFirstVowel(ArrayList<Character> arrayCharacter) {
        for (int idx = 0; idx < arrayCharacter.size(); idx++) {
            if (isVowel(arrayCharacter.get(idx))) {
                return idx;
            }
        }
        return -1;
    }

    /**
     * Metodo que obtiene la posicion de la ultima consonante de un arreglo de
     * caracteres
     * 
     * @param arrayCharacter arreglo de caracteres
     * @return la posicion de la ultima consonante del arreglo, -1 si no hay
     *         consonantes
     */
    public static int getPositionalLastConsonant(ArrayList<Character> arrayCharacter) {
        for (int idx = arrayCharacter.size() - 1; idx >= 0; idx--) {
            if (isConsonant(arrayCharacter.get(idx))) {
                return idx;
            }
        }
        return -1;
    }

    /**
     * Metodo que obtiene los caracteres que son digitos de un arreglo de
     * caracteres
     * 
     * @param arrayCharacter arreglo de caracteres
     * @return un arreglo de caracteres que contiene los caracteres que son digitos
     */
    public static ArrayList<Character> getCharactersDigitsNumbers(ArrayList<Character> arrayCharacter) {
        ArrayList<Character> charactersDigitsNumbers = new ArrayList<>();
        for (int idx = 0; idx < arrayCharacter.size(); idx++) {
            if (Character.isDigit(arrayCharacter.get(idx))) {
                charactersDigitsNumbers.add(arrayCharacter.get(idx));
            }
        }
        return charactersDigitsNumbers;
    }

    /**
     * Metodo que valida si un caracter es un digito
     * 
     * @param character caracter a validar
     * @return true si el caracter es un digito, false si no lo es
     */
    public static boolean charactersDigitsNumbers(char character){
        return "0123456789".indexOf(character)!=-1;
    }

}
