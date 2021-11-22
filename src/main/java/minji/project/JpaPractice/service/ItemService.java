package minji.project.JpaPractice.service;

import lombok.RequiredArgsConstructor;
import minji.project.JpaPractice.repository.ItemRepository;
import minji.project.JpaPractice.web.dto.ItemDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public Long registerItem(ItemDTO itemDTO) {
        return itemRepository.registerItem(itemDTO.toItemEntity());
    }
}
