package com.jotait.utils;

import com.jotait.exception.ComecaComDigitoException;
import com.jotait.exception.PossuiCaracterEspecialException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {

    public static List<String> converterCamelCase(String original) {
        Converter converter = new Converter();
        List<String> listaPalavras;

        if (converter.possuiCaracteresEspeciais(original)) {
            throw new PossuiCaracterEspecialException("A palavra contém caracteres especiais");
        } else if (converter.comecaComDigito(original)) {
            throw new ComecaComDigitoException("A palavra começa com um valor numérico");
        } else {
            listaPalavras = converter.retornaListaPalavras(original);
        }

        return listaPalavras;
    }

    private List<String> retornaListaPalavras(String original) {
        List<String> listaPalavras;

        if (this.naoPossuiNumeros(original) && this.ehAcronimo(original)) {
            listaPalavras = new ArrayList<String>();
            listaPalavras.add(original);
        } else {
            listaPalavras = retornaListaDePalavrasDeUmaLista(Arrays.asList(original.split("(?=\\p{Upper})|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)")));
        }

        return listaPalavras;
    }

    private List<String> retornaListaDePalavrasDeUmaLista(List<String> listaPalavras) {
        if (this.possuiApenasUmaPalavra(listaPalavras)) {
            this.ajustaEscritaApenasUmaPalavra(listaPalavras);
        } else {
            listaPalavras = this.trataListaPalavras(listaPalavras);
        }
        return listaPalavras;
    }

    private boolean possuiCaracteresEspeciais(String original) {
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(original);
        return m.find();
    }

    private List<String> trataListaPalavras(List<String> listaPalavras) {
        List<String> novaListaPalavras = new ArrayList<String>();
        String montarAcronimo = new String();

        for (String palavra : listaPalavras)
            montarAcronimo = this.adicionaPalavra(novaListaPalavras, palavra, montarAcronimo);

        if (montarAcronimo != null && !montarAcronimo.isEmpty()) {
            novaListaPalavras.add(montarAcronimo);
            montarAcronimo = "";
        }

        return novaListaPalavras;
    }

    private void adicionaPalavra(List<String> listaPalavras, String palavra) {
        if (listaPalavras.size() == 0)
            listaPalavras.add(palavra.toLowerCase());
        else
            listaPalavras.add(palavra);
    }

    private String adicionaPalavra(List<String> listaPalavras, String palavra, String acronimo) {
        if (palavra.length() > 1) {

            if (acronimo != null && !acronimo.isEmpty()) {
                listaPalavras.add(acronimo);
                acronimo = "";
            }

            this.adicionaPalavra(listaPalavras, palavra);

        } else {
            acronimo += palavra;
        }

        return acronimo;
    }

    private void ajustaEscritaApenasUmaPalavra(List<String> listaPalavras) {
        listaPalavras.set(0, listaPalavras.get(0).toLowerCase());

    }

    private boolean possuiApenasUmaPalavra(List<String> listaPalavras) {
        return (listaPalavras.size() == 1);
    }

    private boolean ehAcronimo(String palavra) {
        return palavra.toUpperCase().equals(palavra);
    }

    private boolean naoPossuiNumeros(String original) {
        return !original.matches(".*\\d+.*");
    }

    private boolean comecaComDigito(String original) {
        return Character.isDigit(original.charAt(0));
    }


}
