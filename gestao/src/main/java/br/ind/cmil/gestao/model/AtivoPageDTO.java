package br.ind.cmil.gestao.model;

import java.util.List;

/**
 *
 * @author Administrativo
 */
public record AtivoPageDTO(List<AtivoDTO> ativos, long totalElements, int totalPages) {

}
