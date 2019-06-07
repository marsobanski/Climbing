package pl.coderslab.rock;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RockService {

    private RockRepository rockRepository;

    public RockService(RockRepository rockRepository) {
        this.rockRepository = rockRepository;
    }

    public void saveRock(Rock rock) {
        rockRepository.save(rock);
    }

    public void findRockById(Long id) {
        rockRepository.findById(id).orElse(null);
    }

    public void updateRock(Rock rock) {
        rockRepository.save(rock);
    }

    public void deleteRockById(Long id) {
        rockRepository.deleteById(id);
    }
}
