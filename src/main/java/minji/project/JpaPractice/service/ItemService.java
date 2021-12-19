package minji.project.JpaPractice.service;

import lombok.RequiredArgsConstructor;
import minji.project.JpaPractice.domain.Address;
import minji.project.JpaPractice.domain.Member;
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
        return itemRepository.saveItem(itemDTO.toItemEntity());
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

    public ItemDTO findItemById(Long id) {
        Item item = itemRepository.findItemById(id);
        return new ItemDTO(item);
    }

    public Long update(Long id, ItemDTO requestDto) {
        Item item = requestDto.toItemEntity();
        item.setItemId(id);

        return itemRepository.saveItem(item);
    }

    public void delete(Long id) {
        Item item = itemRepository.findItemById(id);
        //엔티티 삭제
        itemRepository.deleteItem(item);
    }
}
