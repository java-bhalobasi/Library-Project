package in.sourav.library.restservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sourav.library.restservice.model.Copy;

public interface CopyRepository extends JpaRepository<Copy,Integer>{

	public List<Copy> findByAvailable(boolean available);
	
	
}
