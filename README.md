
below is the same json data and for the same table  created in dynamoDB I want to read this data using java code and create needed entity and everything

{
 "systemTypeId": 1200002,
 "ruleId": 1,
 "companyId": 200001,
 "domain": "Smart Home",
 "domainId": 1,
 "physicalEquipmentType": "Geyser",
 "regionId": 300001,
 "rule": {
  "recomendation": "Geyser $physicalEquipmentName is ON either for more time or at unwanted time. Operate only as required to save energy.",
  "recomendationPriority": "High",
  "recommendationId": 1,
  "ruleChecks": [
   {
    "aggregationDuration1": "10",
    "aggregationDuration2": "",
    "aggregationDurationUnit1": "mins",
    "aggregationDurationUnit2": "",
    "aggregationType1": "continous",
    "aggregationType2": "",
    "checkTimeslots": [
     {
      "from": 12,
      "to": 22
     }
    ],
    "comparator": "eq",
    "equipmentSensorTag2": "",
    "firstReferenceValue2": "ON",
    "operator": "Or",
    "secondReferenceValue2": "",
    "sensorTag1": "geyser_status"
   },
   {
    "aggregationDuration1": "",
    "aggregationDuration2": "",
    "aggregationDurationUnit1": "",
    "aggregationDurationUnit2": "",
    "aggregationType1": "",
    "aggregationType2": "",
    "checkTimeslots": [
     {
      "from": 1,
      "to": 12
     },
     {
      "from": 22,
      "to": 48
     }
    ],
    "comparator": "eq",
    "equipmentSensorTag2": "",
    "firstReferenceValue2": "ON",
    "operator": "",
    "secondReferenceValue2": "",
    "sensorTag1": "geyser_status"
   }
  ]
 },
 "systemType": "Geyser",
 "tenantId": 100001,
 "type": "rules"
}


