module com.example.jmp.application {
    uses com.example.jmp.bankapi.Bank;
    uses com.example.jmp.service.Service;
    requires com.example.jmp.cloudbankimpl;
    requires com.example.jmp.cloudserviceimpl;
    requires com.example.jmp.dto;
}