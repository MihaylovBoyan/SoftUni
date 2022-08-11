package com.example.mobi.web;

import com.example.mobi.model.binding.OfferAddBindingModel;
import com.example.mobi.model.binding.OfferUpdateBindingModel;
import com.example.mobi.model.entity.enums.EngineEnum;
import com.example.mobi.model.entity.enums.TransmissionEnum;
import com.example.mobi.model.service.OfferAddServiceModel;
import com.example.mobi.model.service.OfferUpdateServiceModel;
import com.example.mobi.model.view.OfferDetailsView;
import com.example.mobi.service.BrandService;
import com.example.mobi.service.ModelService;
import com.example.mobi.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OffersController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;
    private final ModelService modelService;
    private final BrandService brandService;

    public OffersController(OfferService offerService, ModelMapper modelMapper, ModelService modelService, BrandService brandService) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
        this.modelService = modelService;
        this.brandService = brandService;
    }

    @GetMapping("/offers/all")
    public String allOffers(Model model) {

        model.addAttribute("offers", offerService.getAllOffers());

        return "offers";
    }


    @GetMapping("/offers/{id}/details")
    public String showOffer(@PathVariable Long id, Model model) {

        model.addAttribute("offer", offerService.findById(id));

        return "details";
    }

    @GetMapping("/offers/{id}/edit")
    public String editOffer(@PathVariable Long id, Model model) {

        OfferDetailsView offerDetailsView = offerService.findById(id);
        OfferUpdateBindingModel offerModel = modelMapper.map(offerDetailsView, OfferUpdateBindingModel.class);

        model.addAttribute("offerModel", offerModel);
        model.addAttribute("engines", EngineEnum.values());
        model.addAttribute("transmissions", TransmissionEnum.values());

        return "update";
    }

    @GetMapping("/offers/{id}/edit/errors")
    public String editOfferErrors(@PathVariable Long id, Model model) {

        model.addAttribute("engines", EngineEnum.values());
        model.addAttribute("transmissions", TransmissionEnum.values());

        return "update";
    }

    @PatchMapping("offers/{id}/edit")
    public String updateOffer(@PathVariable Long id, @Valid OfferUpdateBindingModel offerModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);

            return "redirect:/offers/" + id + "/edit/errors";
        }

        OfferUpdateServiceModel serviceModel = modelMapper.map(offerModel, OfferUpdateServiceModel.class);
        serviceModel.setId(id);
        offerService.updateOffer(serviceModel);

        return "redirect:/offers/" + id + "/details";
    }


    @DeleteMapping("/offers/{id}")
    public String deleteOffer(@PathVariable Long id) {

        offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }


    @GetMapping("/offers/add")
    public String addOffer(Model model) {

        model.addAttribute("models", modelService.findAllNames());
        model.addAttribute("brands", brandService.findAll());

        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String addOfferConfirm(@Valid OfferAddBindingModel offerAddBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("offerAddBindingModel", offerAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel", bindingResult);

            return "redirect:/offers/add";
        }

        offerService.saveOffer(modelMapper.map(offerAddBindingModel, OfferAddServiceModel.class));

        return "redirect:/offers/all";
    }

    @ModelAttribute
    public OfferAddBindingModel offerAddBindingModel() {
        return new OfferAddBindingModel();
    }

}
