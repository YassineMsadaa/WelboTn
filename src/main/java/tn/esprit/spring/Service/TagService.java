package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Tag;
import tn.esprit.spring.Repository.TagRepository;

import java.util.List;

@Service
public class TagService implements ITagService {

    @Autowired
    TagRepository tagRepository;
    @Override
    public Long ajouterTag(Tag tag) {
        tagRepository.save(tag);
        return tag.getId();
    }

    @Override
    public void deleteTag(Long tagId) {
        tagRepository.deleteById(tagId);

    }

    @Override
    public List<Tag> getTags() {

        return (List<Tag>) tagRepository.findAll();
    }

    @Override
    public Long modifierTag( Tag tag) {
        tagRepository.save(tag);
        return tag.getId();
    }

    @Override
    public Tag getTag(Long tagId) {
        return tagRepository.findById(tagId).get();
    }
}
