package com.solchael.solchael.service;

import com.solchael.solchael.dto.MedicineDto;
import com.solchael.solchael.dto.MedicineResponseDto;
import com.solchael.solchael.entity.Medicine;
import com.solchael.solchael.repository.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineService {

    private final MedicineRepository medicineRepository;

    public List<MedicineResponseDto> searchMedicine(String name) {
        List<Medicine> medicineList = medicineRepository.findByName(name);
        List<MedicineResponseDto> medicines = new ArrayList<>();
        for (Medicine medicine : medicineList) {
            medicines.add(MedicineResponseDto.searchMedicine(medicine.getId(), medicine.getName(), medicine.getItemImage()));
        }
        return medicines;
    }

    public List<MedicineResponseDto> recommendMedicine(String symptom) {
        List<Medicine> medicineList = medicineRepository.findBySymptom(symptom);
        List<MedicineResponseDto> recommend = new ArrayList<>();
        for (Medicine medicine : medicineList) {
            recommend.add(MedicineResponseDto.searchMedicine(medicine.getId(), medicine.getName(), medicine.getItemImage()));
        }
        return recommend;
    }

    public MedicineDto findById(Long id) {
        Medicine medicine = medicineRepository.findById(id);
        return MedicineDto.createMedicine(medicine.getName(), medicine.getUseMethodQesitm(),
                medicine.getEfcyQesitm(), medicine.getAtpnQesitm(), medicine.getSeQesitm(), medicine.getItemImage());
    }
}