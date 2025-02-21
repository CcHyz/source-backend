package com.cc.tips.controller;

import com.cc.tips.JsonDto.JsonDto;
import com.cc.tips.JsonDto.JsonDtoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/json")
public class JsonController {

    private final JsonDtoRepository jsonDtoRepository;

    public JsonController(JsonDtoRepository jsonDtoRepository) {
        this.jsonDtoRepository = jsonDtoRepository;
    }

    @PostMapping(value = "/save")
    public ResponseEntity save() {
        List<JsonDto> jsonDtos = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String json = "{\"personInformationId\":\"0c01e914-28c6-43ec-a3bf-bcfed34314a3\",\"personTicketId\":null,\"qxDate\":\"2023-12-31T16:00:00.000+00:00\",\"initialQxDate\":null,\"personnelInfo\":{\"organizationId\":\"675bd7eb-b450-49c7-a170-d5525a627a00\",\"identityCard\":\"371525200001185760\",\"presentOccupation\":null,\"presentOccupationDate\":null,\"headCountDefinitionId\":null,\"staffCode\":\"00011\",\"staffName\":\"有钱\",\"gender\":\"Male\",\"nationId\":10375,\"birthDate\":\"2000-01-17T16:00:00.000+00:00\",\"politicalStatusId\":11217,\"politicalStatusName\":null,\"departmentName\":null,\"headCountDefinitionDtoName\":null,\"nativePlace\":null,\"address\":null,\"initialPersonalIdentityId\":null,\"staffSourceTypeId\":10460,\"specialAdd\":null,\"departmentId\":null,\"financialPayment\":true,\"financialSupport\":true,\"financialCode\":null,\"recordCode\":null,\"socialismCode\":null,\"enterDate\":\"2019-12-31T16:00:00.000+00:00\",\"joinDate\":\"2019-12-31T16:00:00.000+00:00\",\"jobLimit\":null,\"educationTypeId\":10447,\"degreeTypeId\":null,\"educationType\":null,\"nationName\":null,\"degreeTypeName\":null,\"staffSourceName\":null,\"graduateDate\":\"2019-12-31T16:00:00.000+00:00\",\"workTime\":49,\"beforeWorkTime\":null,\"betweenNotWorkTime\":null,\"staffRemark\":\"调出单位:测试单位6933\",\"localRank\":false,\"professionalCondition\":false,\"localRankOrg\":null,\"professionalConditionInst\":null,\"technicalCertificate\":null,\"academicSection\":null,\"calledTime\":null,\"orderId\":\"00011\",\"personStatus\":null,\"specialFlag\":null,\"createdAt\":\"2024-10-22T16:00:00.000+00:00\",\"receiveUnit\":\"新建测试单位1023\",\"main\":false},\"personWagesInfo\":{\"personalIdentityId\":1240,\"presentOccupation\":\"123\",\"presentOccupationDate\":\"2011-11-10T16:00:00.000+00:00\",\"trueProRankId\":2320,\"levelProRankId\":null,\"levelDate\":null,\"salaryMappingProRankId\":2232045,\"jobNowDate\":\"2011-11-10T16:00:00.000+00:00\",\"trueProRankLeadership\":null,\"leadership\":null,\"titleRankId\":null,\"titleRankDate\":null,\"salaryRank\":null,\"salaryRankDate\":null,\"salaryGrade\":\"1级\",\"salaryGradeDate\":2020,\"standardGradeId\":9314,\"standardProRankId\":9313,\"formerSalaryMappingProRankId\":null,\"formerSalaryRank\":null,\"formerSalaryGrade\":\"1级\",\"highSalaryRank\":null,\"highSalaryRankGist\":null,\"lowSalaryRank\":null,\"lowSalaryRankGist\":null,\"highSalaryGrade\":null,\"highSalaryGradeGist\":null,\"fixedSalaryGrade\":null,\"fixedSalaryGradeGist\":null,\"floatSalaryGrade\":null,\"floatSalaryGradeGist\":null,\"lowSalaryGrade\":null,\"lowSalaryGradeGist\":null,\"jh10PercentUp\":null,\"tsjy15PercentUp\":0.0,\"hgzbl\":0.0,\"jh10PercentHold\":0.0,\"retireSportsManHold\":0.0,\"employeeLevelRetention\":null,\"proRankSalary\":1560.0,\"gradeSalary\":275.0,\"subsidyTotal\":400.0,\"performanceDetailTotal\":0.0,\"sportsManTrainingReward\":null,\"salaryTotal\":2235.0,\"rankingDate\":null,\"note\":null,\"basis\":null,\"standardDate\":\"2021-10-01\",\"attachments\":null,\"teachNursStart\":null,\"teachNursAge\":null,\"maintenance\":null,\"hardshipAreaTypeId\":10943,\"performanceStandard\":\"OtherPublic\",\"highTapAreaTypeId\":\"countyHeadship1\",\"convertWorkAge\":null,\"motivateId\":null,\"capitalReduction\":false,\"compulsoryEducation\":false,\"primaryAndHighSchoolTeacher\":false,\"specialEducation\":false,\"surveyStandard\":false,\"nurse\":false,\"tg10wage\":false},\"personSubsidyInfo\":[{\"id\":15642,\"code\":\"JBT00003\",\"name\":\"回民补贴\",\"amount\":0.0,\"readMark\":null,\"manual\":null},{\"id\":15643,\"code\":\"JBT00070\",\"name\":\"高海拔乡镇临时岗位补贴\",\"amount\":400.0,\"readMark\":null,\"manual\":null},{\"id\":15644,\"code\":\"JBT00074\",\"name\":\"传染病疫情防治人员临时性工作补助\",\"amount\":0.0,\"readMark\":null,\"manual\":null}],\"personPerformanceDetailInfo\":[],\"resumeDto\":{\"qxDate\":null,\"positionHistoryList\":[{\"presentOccupation\":\"123\",\"presentOccupationDate\":\"2011-11-11T00:00:00.000+00:00\",\"personalIdentityId\":1240,\"trueProRankId\":2320,\"levelProRankId\":null,\"levelDate\":null,\"trueProRankLeadership\":null,\"salaryMappingProRankId\":2320,\"leadership\":null,\"jobNowDate\":\"2011-11-11T00:00:00.000+00:00\",\"endDate\":null,\"organizationName\":null}],\"educationHistoryList\":[{\"educationTypeId\":10447,\"graduateDate\":\"2020-01-01T00:00:00.000+00:00\",\"university\":null,\"major\":null,\"remark\":null,\"changeRecordId\":null}],\"workingHistoryDto\":{\"enterDate\":\"2020-01-01T00:00:00.000+00:00\",\"notWorkTime\":0,\"beforeWorkTime\":0,\"betweenNotWorkTime\":0,\"betweenNotServeTime\":0},\"annualCheckList\":[{\"year\":2020,\"result\":\"Qualified\",\"org\":null},{\"year\":2021,\"result\":\"Qualified\",\"org\":null},{\"year\":2022,\"result\":\"Qualified\",\"org\":null},{\"year\":2023,\"result\":\"Qualified\",\"org\":null}],\"highAndLowList\":[],\"personTicketId\":null},\"hardRegionResumeVo\":{\"personInformationId\":\"0c01e914-28c6-43ec-a3bf-bcfed34314a3\",\"qxDate\":null,\"resumeBaseList\":[],\"hardshipAreaTypeId\":null},\"highAltitudeResumeVo\":{\"personInformationId\":\"0c01e914-28c6-43ec-a3bf-bcfed34314a3\",\"qxDate\":null,\"highAltitudeResumeDtoList\":null},\"floatResumeVo\":{\"personInformationId\":\"0c01e914-28c6-43ec-a3bf-bcfed34314a3\",\"qxDate\":null,\"resumeBaseList\":[]},\"seniority\":\"2023-11-30T16:00:00.000+00:00\"}";
            JsonDto jsonDto = new JsonDto();
            jsonDto.setJson(json);
            jsonDtos.add(jsonDto);
        }
        jsonDtoRepository.saveAll(jsonDtos);
        return ResponseEntity.ok().body("ok");
    }

    @PostMapping(value = "/get")
    public ResponseEntity get() {
        return ResponseEntity.ok().body(jsonDtoRepository.findById(1L));
    }
}
