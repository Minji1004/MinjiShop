package minji.project.JpaPractice.service;

import lombok.RequiredArgsConstructor;
import minji.project.JpaPractice.domain.item.Item;
import minji.project.JpaPractice.repository.ItemRepository;
import minji.project.JpaPractice.web.dto.ItemDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public Long registerItem(ItemDTO itemDTO) {
        return itemRepository.registerItem(itemDTO.toItemEntity());
    }

    public List<ItemDTO> findItems() {

        List<Item> itemList = itemRepository.findAll();


        //DTO로 변환
        List<ItemDTO> items = new ArrayList<ItemDTO>();
        for (Item item : itemList) {
            items.add(new ItemDTO(item));
        }

        return items;
    }
}
