package com.example.demo.mappings;

import com.example.demo.dto.response.ContributionResponseDTO;
import com.example.demo.models.Contribution;

public class ContributionMapper {

	public static ContributionResponseDTO toContirbutionResponseDTO(Contribution contri) {
		return new ContributionResponseDTO(
				contri.getId(),
				contri.getAmount(),
				contri.getContributedAt(),
				contri.getContributer().getId(),
				contri.getContributer().getName(),
				contri.getGoal().getId(),
				contri.getGoal().getTitle());
	}
}
