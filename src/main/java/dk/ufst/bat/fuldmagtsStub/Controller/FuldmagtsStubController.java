package dk.ufst.bat.fuldmagtsStub.Controller;

import dk.ufst.bat.fuldmagtsStub.config.*;
import dk.ufst.bat.fuldmagtsStub.config.FuldmagtError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
public class FuldmagtsStubController {
    //region fuldmagter
    Fuldmagt fuldmagt1 = new Fuldmagt("urn:dk:skat:årsopgørelse:se", "Aktiv", "2023-03-14T10:14:31.419Z", "2023-03-14T10:14:31.419Z");
    Fuldmagt fuldmagt2 = new Fuldmagt("urn:dk:skat:årsopgørelse:ret", "Aktiv", "2023-03-14T10:14:31.419Z", "2023-03-14T10:14:31.419Z");
    Fuldmagt fuldmagt3 = new Fuldmagt("urn:dk:skat:forskud:se", "Aktiv", "2023-03-14T10:14:31.419Z", "2023-03-14T10:14:31.419Z");
    Fuldmagt fuldmagt4 = new Fuldmagt("urn:dk:skat:forskud:ret", "Aktiv", "2023-03-14T10:14:31.419Z", "2023-03-14T10:14:31.419Z");

    FuldmagtSvar svar1 = new FuldmagtSvar("String", fuldmagt1);
    FuldmagtSvar svar2 = new FuldmagtSvar("String", fuldmagt2);
    FuldmagtSvar svar3 = new FuldmagtSvar("String", fuldmagt3);
    FuldmagtSvar svar4 = new FuldmagtSvar("String", fuldmagt4);

    FuldmagtData[] myData = {
            new FuldmagtData("nonPersonal", "", svar1),
            new FuldmagtData("personal", "", svar2),
            new FuldmagtData("personal", "", svar4),
            new FuldmagtData("nonPersonal", "", svar3)
    };

    Meta meta = new Meta("3fa85f64-5717-4562-b3fc-2c963f66afa6", "2023-03-17T06:23:07.572Z", "String");
    Links links = new Links("String", "String");
    List<FuldmagtData> testData = Arrays.asList(myData);

    FuldmagtResponse[] myFuldmagtResponse = {
            new FuldmagtResponse(Collections.singletonList(testData), meta, links)

    };

    //endregion
    //region error

    FuldmagtError error1 = new FuldmagtError("Fejl i forspørgelse", "400", "Der er fejl på id i forspørgelsen", "Data", "ikke ok");
    String kode1 = error1.getKode();
    FuldmagtError error2 = new FuldmagtError("Identifikation", "401", "Identifikation fejlede", "Data", "ikke ok");
    String kode2 = error2.getKode();
    FuldmagtError error3 = new FuldmagtError("Autorisation fejlede", "403", "Der er ikke de nødvendige rettigheder", "Data", "ikke ok");
    String kode3 = error3.getKode();

    Map<String, FuldmagtError> errorList = Map.ofEntries(
            Map.entry(kode1, error1),
            Map.entry(kode2, error2),
            Map.entry(kode3, error3)
    );

    //endregion
    @GetMapping("/fuldmagt")
    public FuldmagtResponse getFuldmagtSvar(HttpServletResponse response, HttpServletRequest request) throws IOException {
        FuldmagtResponse rsp = new FuldmagtResponse();
        String type = request.getParameter("type");

        List<Object> filteredList = new ArrayList<>();

        if (!type.isEmpty()) {
            for (FuldmagtData obj : myData) {
                if (obj.getType().equals(type)) {

                    filteredList.add(obj);
                    rsp.setData(Collections.singletonList(filteredList));
                    rsp.setMeta(meta);
                    rsp.setLinks(links);
                }
                else {
                    int code = Integer.parseInt(error1.getKode());

                    filteredList.add(error1);
                    rsp.setData(Collections.singletonList(filteredList));
                    rsp.setMeta(meta);
                    rsp.setLinks(links);

                    response.setStatus(code);
                }
            }

        } else {
            int code = Integer.parseInt(error1.getKode());

            filteredList.add(error1);
            rsp.setData(Collections.singletonList(filteredList));
            rsp.setMeta(meta);
            rsp.setLinks(links);

            response.setStatus(code);

        }

        return rsp;

    }

    @GetMapping("/foo")
    public List<FuldmagtData> getResponse(HttpServletResponse response, HttpServletRequest request) {

        String type = request.getParameter("type");

        List<FuldmagtData> filteredList = new ArrayList<>();

        if (!type.isEmpty()) {

            for (FuldmagtData obj : myData) {
                if (obj.getType().equals(type)) {
                    filteredList.add(obj);
                }
            }

        }

        return filteredList;
    }

    @GetMapping("/bar")
    public FuldmagtResponse[] getBar(HttpServletResponse response, HttpServletRequest request) throws IOException {
//        String cvr = request.getParameter("cvr");
//        String cpr = request.getParameter("cpr");
//
//        List<Fuldmagt> liste = new ArrayList<>();
//        if (!cvr.isEmpty()){
//            if (fuldmagter.containsKey(cvr)){
//                for (Map.Entry<String, Fuldmagt> entry : fuldmagter.entrySet()) {
//                    liste.add( fuldmagter.get(cvr));
//
//                }
//            }
//            else {
//                int code = Integer.parseInt(error2.getKode());
//                String message = error2.getBesked();
//                response.setStatus(code);
//                response.getWriter().write(message);
////                for (Map.Entry<String, Error> errorEntry : errorList.entrySet()) {
////                    return errorList.get(test);
////                }
//            }
//
//        } else {
//            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameter cvr");
//        }
//
//        return liste;
        return myFuldmagtResponse;
    }

}
