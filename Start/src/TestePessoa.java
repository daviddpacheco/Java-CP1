import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestePessoa {

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();

        pessoas = adicionarPessoa(pessoas, new Pessoa("João", "123456789", 25));
        pessoas = adicionarPessoa(pessoas, new Pessoa("Maria", "987654321", 30));
        pessoas = adicionarPessoa(pessoas, new Pessoa("Ana", "123456789", 22));

        System.out.println("Lista de pessoas:");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }

        pessoas = removerDuplicados(pessoas);

        System.out.println("\nLista de pessoas sem duplicados:");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }

        Map<String, Pessoa> mapaPessoas = new HashMap<>();
        adicionarAoMapa(mapaPessoas, new Pessoa("Carlos", "112233445", 28));

        System.out.println("\nPessoa no mapa:");
        System.out.println(mapaPessoas.get("112233445"));

        List<Pessoa> listaOrdenadaCrescente = new ArrayList<>(pessoas);
        List<Pessoa> listaOrdenadaDecrescente = new ArrayList<>(pessoas);

        ordenarLista(listaOrdenadaCrescente, true);
        ordenarLista(listaOrdenadaDecrescente, false);

        System.out.println("\nLista ordenada de forma crescente:");
        for (Pessoa pessoa : listaOrdenadaCrescente) {
            System.out.println(pessoa);
        }

        System.out.println("\nLista ordenada de forma decrescente:");
        for (Pessoa pessoa : listaOrdenadaDecrescente) {
            System.out.println(pessoa);
        }
    }

    public static List<Pessoa> adicionarPessoa(List<Pessoa> lista, Pessoa pessoa) {
        lista.add(pessoa);
        return lista;
    }

    public static List<Pessoa> removerDuplicados(List<Pessoa> lista) {
        Set<Pessoa> set = new HashSet<>(lista);
        return new ArrayList<>(set);
    }

    public static void adicionarAoMapa(Map<String, Pessoa> mapa, Pessoa pessoa) {
        mapa.put(pessoa.getDocumento(), pessoa);
    }

    public static void ordenarLista(List<Pessoa> lista, boolean crescente) {
        lista.sort((p1, p2) -> {
            if (crescente) {
                return p1.getNome().compareTo(p2.getNome());
            } else {
                return p2.getNome().compareTo(p1.getNome());
            }
        });
    }
}
