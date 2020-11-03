package REST;

import Services.AdminService;
import entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Admin")
public class AdminRest {

    @Autowired
    private AdminService adminService;

    @GetMapping("/id/{id}")
    public Optional<Admin> findbyId(@PathVariable Long id) {
        return adminService.findbyId(id);
    }
    @GetMapping("/")
    public List<Admin> findall() {
        return adminService.findall();
    }

    @PostMapping("/")
    public int save(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @DeleteMapping("/{admin}")
    public void delete(@RequestBody Admin admin) {
        adminService.delete(admin);
    }




}
