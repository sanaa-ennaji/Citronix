package org.sanaa.setnence.citronix.citronix.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sanaa.setnence.citronix.citronix.mapper.GenericMapper;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.GenericServiceI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
public class GenericService<Entity, CreateDTO, UpdateDTO, ResponseDTO> implements GenericServiceI<Entity, CreateDTO, UpdateDTO, ResponseDTO> {

    protected final GenericMapper<Entity, CreateDTO, UpdateDTO, ResponseDTO> mapper;
    protected final JpaRepository<Entity, Long> repository;

    @Override
    public ResponseDTO create(CreateDTO createDTO) {
        Entity entity = mapper.toEntity(createDTO);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public ResponseDTO update(Long id, UpdateDTO updateDTO) {
        Optional<Entity> optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty()) {
            throw new EntityNotFoundException("entity not found with id: " + id);
        }
        Entity entity = optionalEntity.get();
        mapper.updateEntityFromDTO(updateDTO, entity);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public Optional<ResponseDTO> findById(Long id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Override
    public List<ResponseDTO> findAll() {
        List<Entity> entities = repository.findAll();
        return mapper.toDTOs(entities);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("entity not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
