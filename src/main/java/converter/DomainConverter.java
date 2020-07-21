package converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import dto.DomainsDTO;
import model.Domains;

@Component
public class DomainConverter {
	
	public DomainsDTO entityToDTO(Domains domain){
		
		ModelMapper mapper = new ModelMapper();
		DomainsDTO map = mapper.map(domain, DomainsDTO.class);
		
		return map;
	}
	
	public List<DomainsDTO> entityToDTO(List<Domains> domain){
		return domain.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
	}
	
	public Domains dtoToEntity(DomainsDTO dto) {
		ModelMapper mapper = new ModelMapper();
		Domains map = mapper.map(dto, Domains.class);
		return map;
	}
	
	public List<Domains> dtoToEntity(List<DomainsDTO> dto){
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
