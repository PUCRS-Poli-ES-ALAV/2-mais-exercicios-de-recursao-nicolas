import java.util.ArrayList;

public class Exercicios {
    // Modelagem: Se n < 0, lança exceção. Se n == 0 ou n == 1, retorna 1. Caso contrário, retorna n * fatorial(n - 1).
    public static long fatorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Número deve ser não negativo");
        }
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * fatorial(n - 1);
        }
    }

    // Modelagem: Se n == 0, retorna 0. Caso contrário, retorna n + somatorio(n - 1). (Demonstrativo)
    public static int somatorio(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + somatorio(n - 1);
        }
    }

    // Modelagem: Se n == 0, retorna 0. Se n == 1, retorna 1. Caso contrário, retorna fibonacci(n-1) + fibonacci(n-2). (Demonstrativo)
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // Modelagem: Se k > j, retorna 0. Caso contrário, retorna k + somatorioEntre(k+1, j). (Demonstrativo)
    public static int somatorioEntre(int k, int j) {
        if (k > j) {
            return 0;
        } else {
            return k + somatorioEntre(k + 1, j);
        }
    }

    // Modelagem: Se a string tem tamanho 0 ou 1, retorna true. Caso contrário, verifica se o primeiro e último caracteres são iguais e chama isPal no restante. (Declarativo)
    public static boolean isPal(String s) {
        if (s.length() <= 1) {
            return true;
        } else {
            return (s.charAt(0) == s.charAt(s.length() - 1)) && isPal(s.substring(1, s.length() - 1));
        }
    }

    // Modelagem: Se n == 0, retorna "0". Se n == 1, retorna "1". Caso contrário, retorna convBase2(n/2) + (n%2). (Demonstrativo)
    public static String convBase2(int n) {
        if (n == 0) {
            return "0";
        } else if (n == 1) {
            return "1";
        } else {
            return convBase2(n / 2) + (n % 2);
        }
    }

    // Modelagem: Se a lista estiver vazia, retorna 0. Caso contrário, retorna o primeiro elemento + somaArray(restante da lista). (Demonstrativo)
    public static int somaArray(ArrayList<Integer> lista) {
        if (lista.isEmpty()) {
            return 0;
        } else {
            return lista.remove(0) + somaArray(lista);
        }
    }

    // Modelagem: Se a lista tem um elemento, retorna esse elemento. Caso contrário, compara o primeiro com o maior do restante. (Declarativo)
    public static int findBiggest(ArrayList<Integer> lista) {
        if (lista.size() == 1) {
            return lista.get(0);
        } else {
            int primeiro = lista.remove(0);
            return Math.max(primeiro, findBiggest(lista));
        }
    }

    // Modelagem: Se match for vazio, retorna true. Se str for menor que match, retorna false. Verifica se começa igual ou chama findSubStr no sufixo de str. (Demonstrativo)
    public static boolean findSubStr(String str, String match) {
        if (match.isEmpty()) {
            return true;
        } else if (str.length() < match.length()) {
            return false;
        } else {
            return str.startsWith(match) || findSubStr(str.substring(1), match);
        }
    }

    // Modelagem: Se n < 10, retorna 1. Caso contrário, retorna 1 + nroDigit(n/10). (Demonstrativo)
    public static int nroDigit(int n) {
        if (n < 10) {
            return 1;
        } else {
            return 1 + nroDigit(n / 10);
        }
    }

    // Modelagem: Se a string for vazia, retorna lista com "". Para cada caractere, insere em todas as posições das permutações do restante. (Demonstrativo)
    public static ArrayList<String> permutations(String s) {
        ArrayList<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            result.add("");
            return result;
        } else {
            char first = s.charAt(0);
            ArrayList<String> words = permutations(s.substring(1));
            for (String word : words) {
                for (int i = 0; i <= word.length(); i++) {
                    result.add(word.substring(0, i) + first + word.substring(i));
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println("Fatorial de 5: " + fatorial(5));
        System.out.println("Somatório de 5: " + somatorio(5));
        System.out.println("Fibonacci de 6: " + fibonacci(6));
        System.out.println("Somatório entre 3 e 7: " + somatorioEntre(3, 7));
        System.out.println("É palíndromo 'radar': " + isPal("radar"));
        System.out.println("Número 10 em binário: " + convBase2(10));

        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        System.out.println("Somatório do ArrayList: " + somaArray(new ArrayList<>(lista)));
        System.out.println("Maior elemento do ArrayList: " + findBiggest(new ArrayList<>(lista)));
        
        System.out.println("Substring 'lo' em 'hello': " + findSubStr("hello", "lo"));
        System.out.println("Número de dígitos de 1234: " + nroDigit(1234));
        System.out.println("Permutações de 'abc': " + permutations("abc"));
    }
}
