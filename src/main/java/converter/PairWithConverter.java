package converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import dto.PairWithDTO;
import model.PairWith;

@Component
public class PairWithConverter {
	
	public PairWithDTO entityToDTO(PairWith entity){
		
		ModelMapper mapper = new ModelMapper();
		PairWithDTO map = mapper.map(entity, PairWithDTO.class);
		
		return map;
	}
	
	public List<PairWithDTO> entityToDTO(List<PairWith> entity){
		return entity.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
	}
	
	public PairWith dtoToEntity(PairWithDTO dto) {
		ModelMapper mapper = new ModelMapper();
		PairWith map = mapper.map(dto, PairWith.class);
		return map;
	}
	
	public List<PairWith> dtoToEntity(List<PairWithDTO> dto){
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
