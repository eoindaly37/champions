package converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import dto.LookForHelpDTO;
import model.LookForHelp;

@Component
public class LookForHelpConverter {
	
	public LookForHelpDTO entityToDTO(LookForHelp entity){
		
		ModelMapper mapper = new ModelMapper();
		LookForHelpDTO map = mapper.map(entity, LookForHelpDTO.class);
		
		return map;
	}
	
	public List<LookForHelpDTO> entityToDTO(List<LookForHelp> entity){
		return entity.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
	}
	
	public LookForHelp dtoToEntity(LookForHelpDTO dto) {
		ModelMapper mapper = new ModelMapper();
		LookForHelp map = mapper.map(dto, LookForHelp.class);
		return map;
	}
	
	public List<LookForHelp> dtoToEntity(List<LookForHelpDTO> dto){
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
