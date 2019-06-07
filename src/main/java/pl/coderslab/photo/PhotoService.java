package pl.coderslab.photo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PhotoService {

    private PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public void savePhoto(Photo photo) {
        photoRepository.save(photo);
    }

    public void findPhotoById(Long id) {
        photoRepository.findById(id).orElse(null);
    }

    public void updatePhoto(Photo photo) {
        photoRepository.save(photo);
    }

    public void deletePhotoById(Long id) {
        photoRepository.deleteById(id);
    }
}
