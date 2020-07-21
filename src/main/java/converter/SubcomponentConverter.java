package converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import dto.SubcomponentsDTO;
import model.Subcomponents;

@Component
public class SubcomponentConverter {
	
	public SubcomponentsDTO entityToDTO(Subcomponents subcomponent){
		
		ModelMapper mapper = new ModelMapper();
		SubcomponentsDTO map = mapper.map(subcomponent, SubcomponentsDTO.class);
		
		return map;
	}
	
	public List<SubcomponentsDTO> entityToDTO(List<Subcomponents> subcomponent){
		return subcomponent.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
	}
	
	public Subcomponents dtoToEntity(SubcomponentsDTO dto) {
		ModelMapper mapper = new ModelMapper();
		Subcomponents map = mapper.map(dto, Subcomponents.class);
		return map;
	}
	
	public List<Subcomponents> dtoToEntity(List<SubcomponentsDTO> dto){
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
