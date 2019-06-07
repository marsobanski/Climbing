package pl.coderslab.area;

import javax.transaction.Transactional;

@Transactional
public class AreaService {

    private AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public void saveArea(Area area) {
        areaRepository.save(area);
    }

    public void findAreaById(Long id) {
        areaRepository.findById(id).orElse(null);
    }

    public void updateArea(Area area) {
        areaRepository.save(area);
    }

    public void deleteAreaById(Long id) {
        areaRepository.deleteById(id);
    }
}
